#!/usr/bin/env python3
import base64
import json
import jwt # note this is the PyJWT module, not python-jwt

encoded = jwt.encode({'username': 'matias', 'admin': True })
print(encoded)