/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fileencryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Nofrisal Dwi S
 */
public class Encrypt {
    public static void encrypt(File src, File dest)
            throws IOException {

        
            //if file, then copy it
            //Use bytes stream to support all file types
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int length;
            int key = 3;
            //copy the file content in bytes 
            while ((length = in.read(buffer)) > 0) {
                for (int i=0; i< length; i++){
                    if(buffer[i] >= 'a' && buffer[i] <= 'z')
                    {
                        buffer[i] = (byte) (buffer[i] + key);
                        if (buffer[i] > 'z')
                        {
                            buffer[i] = (byte) (buffer[i]+'a'-'z'-1);
                        }
                    }
                    else if(buffer[i] >= 'A' && buffer[i] <= 'Z')
                    {
                        buffer[i] = (byte) (buffer[i] + key);
                        if (buffer[i] > 'Z')
                        {
                            buffer[i] = (byte) (buffer[i]+'A'-'Z'-1);
                        }
                    }
                }
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
            System.out.println("File copied from " + src + " to " + dest);
        }
    }