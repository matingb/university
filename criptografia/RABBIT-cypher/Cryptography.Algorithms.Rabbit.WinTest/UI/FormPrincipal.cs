using Cryptography.Algorithms.Rabbit.WinTest.Proceso;
using System;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Windows.Forms;

namespace Cryptography.Algorithms.Rabbit.WinTest.UI
{
    public partial class FormPrincipal : Form
    {
                
        public FormPrincipal()
        {
            InitializeComponent();
        }

        private void FormPrincipal_Load(object sender, EventArgs e)
        {

        }

        private void SetData(PictureBox pb, TextBox txtBytes, byte[] bytes)
        {
            pb.Image = ByteToImage(bytes);
            pb.Tag = bytes;

            txtBytes.Text = ByteArrayToString(bytes);
        }

        public string ByteArrayToString(byte[] ba)
        {
            StringBuilder hex = new StringBuilder(ba.Length * 2);
            foreach (byte b in ba)
                hex.AppendFormat("{0:x2}", b);
            return hex.ToString();
        }

        private Image ByteToImage(byte[] bytes)
        {
            try
            {
                MemoryStream mStream = new MemoryStream();
                byte[] pData = bytes;
                mStream.Write(pData, 0, Convert.ToInt32(pData.Length));
                Bitmap bitmap = new Bitmap(mStream, false);
                mStream.Dispose();
                return bitmap;
            }
            catch(Exception ex)
            {
                ex.ToString();
                try 
                { 
                    return CipherBytesToImage(bytes); 
                }
                catch (Exception e)
                {
                    e.ToString();
                }

                return null;
            }
        }

        public Image CipherBytesToImage(byte[] bytes)
        {
            int size = (int)Math.Sqrt(bytes.Length); // Some bytes will not be used as we round down here

            Bitmap bitmap = new Bitmap(size, size, PixelFormat.Format8bppIndexed);
            BitmapData bitmapData = bitmap.LockBits(new Rectangle(0, 0, bitmap.Width, bitmap.Height), ImageLockMode.WriteOnly, bitmap.PixelFormat);

            try
            {
                // Copy byteArrayIn to bitmapData row by row (to account for the case
                // where bitmapData.Stride != bitmap.Width)
                for (int rowIndex = 0; rowIndex < bitmapData.Height; ++rowIndex)
                    Marshal.Copy(bytes, rowIndex * bitmap.Width, bitmapData.Scan0 + rowIndex * bitmapData.Stride, bitmap.Width);
            }
            finally
            {
                bitmap.UnlockBits(bitmapData);
            }

            return bitmap;
        }

        private byte[] imgCipher()
        {
            // retorna imagen cifrada 
            return ProcesoPrincipal.Instancia.Cipher(txtKeyInicial.Text, txtIVInicial.Text, (byte[]) pbImagenInicial.Tag);
        }

        private void BtnCopiarConfig_Click(object sender, EventArgs e)
        {
            txtKeyFinal.Text = txtKeyInicial.Text;
            txtIVFinal.Text = txtIVInicial.Text;
        }

        private void BtnImagen_Click(object sender, EventArgs e)
        {
            using (var dialog = new OpenFileDialog())
            {
                dialog.Filter = "Image files (*.jpg, *.jpeg, *.jpe, *.jfif, *.png) | *.jpg; *.jpeg; *.jpe; *.jfif; *.png";
                if (dialog.ShowDialog() == DialogResult.OK)
                {
                    string file = dialog.FileName;
                    try
                    {
                        var bytes = File.ReadAllBytes(file);
                        SetData(pbImagenInicial, txtBytesInicial, bytes);
                        SetData(pbImagenRabbit, txtBytesRabbit, new byte[0]);
                    }
                    catch
                    {
                    }
                }
            }
        }

        private void BtnBytes_Click(object sender, EventArgs e)
        {
            using (var dialog = new OpenFileDialog())
            {
                dialog.Filter = "Text files (*.txt)|*.txt";
                if (dialog.ShowDialog() == DialogResult.OK)
                {
                    string file = dialog.FileName;
                    try
                    {
                        string texto = File.ReadAllText(file);

                        byte[] bytes = new byte[texto.Length / 2];
                        for (int i = 0; i < texto.Length; i += 2)
                        {
                            string hexByte = texto.Substring(i, 2);
                            bytes[i / 2] = Convert.ToByte(hexByte, 16);
                        }

                        SetData(pbImagenInicial, txtBytesInicial, bytes);
                        SetData(pbImagenRabbit, txtBytesRabbit, new byte[0]);
                    }
                    catch (IOException exception)
                    {
                        MessageBox.Show($"Error reading the file: {exception.Message}");
                    }
                }
            }
        }

        private void BtnCifrar_Click(object sender, EventArgs e)
        {
            SetData(pbImagenRabbit, txtBytesRabbit, imgCipher());
        }

        private void BtnGuardar_Click(object sender, EventArgs e)
            {
                if (pbImagenRabbit.Image != null)
                {
                    using (SaveFileDialog saveDialog = new SaveFileDialog())
                    {
                        saveDialog.Filter = "Archivos de imagen|*.png;*.jpg;*.jpeg|Todos los archivos|*.*";
                        if (saveDialog.ShowDialog() == DialogResult.OK)
                        {
                            string filePath = saveDialog.FileName;

                            // Obtener el formato de imagen actual
                            ImageFormat formato = pbImagenInicial.Image.RawFormat;

                            // Obtener el códec de imagen correspondiente al formato actual
                            ImageCodecInfo codecInfo = ImageCodecInfo.GetImageDecoders()
                                .FirstOrDefault(codec => codec.FormatID == formato.Guid);

                            // Configurar los parámetros de codificación para mantener el formato original
                            EncoderParameters encoderParams = new EncoderParameters(1);
                            encoderParams.Param[0] = new EncoderParameter(System.Drawing.Imaging.Encoder.Quality, 100L); // Puedes ajustar el nivel de calidad si es necesario

                            // Guardar la imagen en el formato original
                            pbImagenRabbit.Image.Save(filePath, codecInfo, encoderParams);

                            MessageBox.Show("Imagen guardada exitosamente.");
                        }
                    }
                }
                else
                {
                    MessageBox.Show("No hay una imagen para guardar.");
                }
            }

        }
}
