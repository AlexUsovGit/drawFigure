package com.uaa.javamsgfx.classes;

import com.uaa.javamsgfx.interfaces.Printable;

import java.io.*;
import java.util.List;

public class Logger<T extends Printable> {

    private List <Figure> figures;
    private static final String defaultFileName = "save.dat";



    public void log2(Figure figure) {
        File file = new File("figureLog.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("проблемы с файлом");
                return;
            }
        }
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file, true));
            String data = figure.getInfo() + "\n";
            bos.write(data.getBytes());
            bos.flush();
            bos.close();


           // figures = (List <Figure>) deserialize(param);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void serialize (List <? extends Serializable> obj,String file){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)));
            oos.writeObject(obj);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public Object deserialize(String file){
        File f = new File(file);

        Object object = null;
        if (!f.exists() ){

            return object;
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(f)));
            object = ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

}


