/**
 * Copyright (c) 2010-2011 Engine Yard, Inc.
 * Copyright (c) 2007-2009 Sun Microsystems, Inc.
 * This source code is available under the MIT license.
 * See the file LICENSE.txt for details.
 */

import java.net.URLClassLoader;
import java.net.URL;
import java.lang.reflect.Method;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

public class RakeWarMain {
    public static final String MAIN = "/" + RakeWarMain.class.getName().replace('.', '/') + ".class";

    public static void main(String[] args) {
        try {
            URL mainClass = RakeWarMain.class.getResource(MAIN);
            String path = mainClass.toURI().getSchemeSpecificPart();
            String warfile = path.replace("!" + MAIN, "").replace("file:", "");

            System.out.println("RUNNING RakeWarMain");
            System.out.println("path: " + path);
            System.out.println("warfile: " + warfile);
            System.out.println("classpath:" + System.getProperty("java.class.path"));
        } catch (Exception e) {
            Throwable t = e;
            while (t.getCause() != null && t.getCause() != t) {
                t = t.getCause();
            }

            t.printStackTrace();

            System.exit(1);
        }
    }
}

