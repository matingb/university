namespace Cryptography.Algorithms.Rabbit.WinTest.UI
{
    partial class FormPrincipal
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.pbImagenInicial = new System.Windows.Forms.PictureBox();
            this.btnCifrar = new System.Windows.Forms.Button();
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.pbImagenRabbit = new System.Windows.Forms.PictureBox();
            this.txtBytesRabbit = new System.Windows.Forms.TextBox();
            this.txtBytesInicial = new System.Windows.Forms.TextBox();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.lblDescifrado = new System.Windows.Forms.Label();
            this.lblCifrado = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.txtIVFinal = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.txtKeyFinal = new System.Windows.Forms.TextBox();
            this.btnImagen = new System.Windows.Forms.Button();
            this.btnBytes = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.txtIVInicial = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.txtKeyInicial = new System.Windows.Forms.TextBox();
            this.btnGuardar = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.pbImagenInicial)).BeginInit();
            this.tabControl1.SuspendLayout();
            this.tabPage1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbImagenRabbit)).BeginInit();
            this.tabPage2.SuspendLayout();
            this.SuspendLayout();
            // 
            // pbImagenInicial
            // 
            this.pbImagenInicial.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pbImagenInicial.Location = new System.Drawing.Point(6, 6);
            this.pbImagenInicial.Name = "pbImagenInicial";
            this.pbImagenInicial.Size = new System.Drawing.Size(360, 300);
            this.pbImagenInicial.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbImagenInicial.TabIndex = 0;
            this.pbImagenInicial.TabStop = false;
            // 
            // btnCifrar
            // 
            this.btnCifrar.Location = new System.Drawing.Point(35, 562);
            this.btnCifrar.Name = "btnCifrar";
            this.btnCifrar.Size = new System.Drawing.Size(366, 47);
            this.btnCifrar.TabIndex = 12;
            this.btnCifrar.Text = "CIFRAR";
            this.btnCifrar.UseVisualStyleBackColor = true;
            this.btnCifrar.Click += new System.EventHandler(this.BtnCifrar_Click);
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabPage1);
            this.tabControl1.Controls.Add(this.tabPage2);
            this.tabControl1.Location = new System.Drawing.Point(31, 8);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(777, 545);
            this.tabControl1.TabIndex = 14;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.pbImagenRabbit);
            this.tabPage1.Controls.Add(this.txtBytesRabbit);
            this.tabPage1.Controls.Add(this.txtBytesInicial);
            this.tabPage1.Controls.Add(this.pbImagenInicial);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(769, 519);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "Visualizador";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // pbImagenRabbit
            // 
            this.pbImagenRabbit.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pbImagenRabbit.Location = new System.Drawing.Point(372, 6);
            this.pbImagenRabbit.Name = "pbImagenRabbit";
            this.pbImagenRabbit.Size = new System.Drawing.Size(360, 300);
            this.pbImagenRabbit.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbImagenRabbit.TabIndex = 22;
            this.pbImagenRabbit.TabStop = false;
            // 
            // txtBytesRabbit
            // 
            this.txtBytesRabbit.Location = new System.Drawing.Point(372, 312);
            this.txtBytesRabbit.Multiline = true;
            this.txtBytesRabbit.Name = "txtBytesRabbit";
            this.txtBytesRabbit.ReadOnly = true;
            this.txtBytesRabbit.Size = new System.Drawing.Size(360, 200);
            this.txtBytesRabbit.TabIndex = 21;
            // 
            // txtBytesInicial
            // 
            this.txtBytesInicial.Location = new System.Drawing.Point(6, 312);
            this.txtBytesInicial.Multiline = true;
            this.txtBytesInicial.Name = "txtBytesInicial";
            this.txtBytesInicial.ReadOnly = true;
            this.txtBytesInicial.Size = new System.Drawing.Size(360, 200);
            this.txtBytesInicial.TabIndex = 16;
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.lblDescifrado);
            this.tabPage2.Controls.Add(this.lblCifrado);
            this.tabPage2.Controls.Add(this.label3);
            this.tabPage2.Controls.Add(this.txtIVFinal);
            this.tabPage2.Controls.Add(this.label4);
            this.tabPage2.Controls.Add(this.txtKeyFinal);
            this.tabPage2.Controls.Add(this.btnImagen);
            this.tabPage2.Controls.Add(this.btnBytes);
            this.tabPage2.Controls.Add(this.label2);
            this.tabPage2.Controls.Add(this.txtIVInicial);
            this.tabPage2.Controls.Add(this.label1);
            this.tabPage2.Controls.Add(this.txtKeyInicial);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(769, 519);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "Inicializacion";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // lblDescifrado
            // 
            this.lblDescifrado.AutoSize = true;
            this.lblDescifrado.Location = new System.Drawing.Point(40, 241);
            this.lblDescifrado.Name = "lblDescifrado";
            this.lblDescifrado.Size = new System.Drawing.Size(58, 13);
            this.lblDescifrado.TabIndex = 25;
            this.lblDescifrado.Text = "Descifrado";
            // 
            // lblCifrado
            // 
            this.lblCifrado.AutoSize = true;
            this.lblCifrado.Location = new System.Drawing.Point(40, 60);
            this.lblCifrado.Name = "lblCifrado";
            this.lblCifrado.Size = new System.Drawing.Size(40, 13);
            this.lblCifrado.TabIndex = 24;
            this.lblCifrado.Text = "Cifrado";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(55, 306);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(17, 13);
            this.label3.TabIndex = 22;
            this.label3.Text = "IV";
            // 
            // txtIVFinal
            // 
            this.txtIVFinal.Location = new System.Drawing.Point(55, 322);
            this.txtIVFinal.Name = "txtIVFinal";
            this.txtIVFinal.Size = new System.Drawing.Size(656, 20);
            this.txtIVFinal.TabIndex = 21;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(55, 267);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(25, 13);
            this.label4.TabIndex = 20;
            this.label4.Text = "Key";
            // 
            // txtKeyFinal
            // 
            this.txtKeyFinal.Location = new System.Drawing.Point(55, 283);
            this.txtKeyFinal.Name = "txtKeyFinal";
            this.txtKeyFinal.Size = new System.Drawing.Size(656, 20);
            this.txtKeyFinal.TabIndex = 19;
            // 
            // btnImagen
            // 
            this.btnImagen.Location = new System.Drawing.Point(55, 191);
            this.btnImagen.Name = "btnImagen";
            this.btnImagen.Size = new System.Drawing.Size(320, 23);
            this.btnImagen.TabIndex = 18;
            this.btnImagen.Text = "Seleccionar imagen";
            this.btnImagen.UseVisualStyleBackColor = true;
            this.btnImagen.Click += new System.EventHandler(this.BtnImagen_Click);
            // 
            // btnBytes
            // 
            this.btnBytes.Location = new System.Drawing.Point(381, 191);
            this.btnBytes.Name = "btnBytes";
            this.btnBytes.Size = new System.Drawing.Size(320, 23);
            this.btnBytes.TabIndex = 18;
            this.btnBytes.Text = "Cargar Imagen desde Bytes";
            this.btnBytes.UseVisualStyleBackColor = true;
            this.btnBytes.Click += new System.EventHandler(this.BtnBytes_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(55, 121);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(17, 13);
            this.label2.TabIndex = 17;
            this.label2.Text = "IV";
            // 
            // txtIVInicial
            // 
            this.txtIVInicial.Location = new System.Drawing.Point(55, 137);
            this.txtIVInicial.Name = "txtIVInicial";
            this.txtIVInicial.Size = new System.Drawing.Size(656, 20);
            this.txtIVInicial.TabIndex = 16;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(55, 82);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(25, 13);
            this.label1.TabIndex = 15;
            this.label1.Text = "Key";
            // 
            // txtKeyInicial
            // 
            this.txtKeyInicial.Location = new System.Drawing.Point(55, 98);
            this.txtKeyInicial.Name = "txtKeyInicial";
            this.txtKeyInicial.Size = new System.Drawing.Size(656, 20);
            this.txtKeyInicial.TabIndex = 14;
            // 
            // btnGuardar
            // 
            this.btnGuardar.Location = new System.Drawing.Point(407, 562);
            this.btnGuardar.Name = "btnGuardar";
            this.btnGuardar.Size = new System.Drawing.Size(360, 47);
            this.btnGuardar.TabIndex = 16;
            this.btnGuardar.Text = "GUARDAR";
            this.btnGuardar.UseVisualStyleBackColor = true;
            this.btnGuardar.Click += new System.EventHandler(this.BtnGuardar_Click);
            // 
            // FormPrincipal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(820, 616);
            this.Controls.Add(this.btnGuardar);
            this.Controls.Add(this.tabControl1);
            this.Controls.Add(this.btnCifrar);
            this.Name = "FormPrincipal";
            this.Text = "Rabbit";
            this.Load += new System.EventHandler(this.FormPrincipal_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pbImagenInicial)).EndInit();
            this.tabControl1.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbImagenRabbit)).EndInit();
            this.tabPage2.ResumeLayout(false);
            this.tabPage2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox pbImagenInicial;
        private System.Windows.Forms.Button btnCifrar;
        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.TextBox txtBytesInicial;
        private System.Windows.Forms.Button btnGuardar;
        private System.Windows.Forms.PictureBox pbImagenRabbit;
        private System.Windows.Forms.TextBox txtBytesRabbit;
        private System.Windows.Forms.Label lblDescifrado;
        private System.Windows.Forms.Label lblCifrado;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtIVFinal;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txtKeyFinal;
        private System.Windows.Forms.Button btnImagen;
        private System.Windows.Forms.Button btnBytes;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtIVInicial;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtKeyInicial;
    }
}

