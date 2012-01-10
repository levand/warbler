/**
 * Copyright (c) 2010-2011 Engine Yard, Inc.
 * Copyright (c) 2007-2009 Sun Microsystems, Inc.
 * This source code is available under the MIT license.
 * See the file LICENSE.txt for details.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class RakeWarMain extends JarMain{

    public RakeWarMain(String[] args) throws Exception {
        super(args);
    }

    private int launchRake(URL[] jars) throws Exception {

        System.out.println("Working so far...");
        return 0;

        // System.setProperty("org.jruby.embed.class.path", "");
        // URLClassLoader loader = new URLClassLoader(jars);
        // Class scriptingContainerClass = Class.forName("org.jruby.embed.ScriptingContainer", true, loader);
        // Object scriptingContainer = scriptingContainerClass.newInstance();

        // Method argv = scriptingContainerClass.getDeclaredMethod("setArgv", new Class[] {String[].class});
        // argv.invoke(scriptingContainer, new Object[] {args});
        // Method setClassLoader = scriptingContainerClass.getDeclaredMethod("setClassLoader", new Class[] {ClassLoader.class});
        // setClassLoader.invoke(scriptingContainer, new Object[] {loader});
        // debug("invoking " + jarfile + " with: " + Arrays.deepToString(args));

        // Method runScriptlet = scriptingContainerClass.getDeclaredMethod("runScriptlet", new Class[] {String.class});
        // return ((Number) runScriptlet.invoke(scriptingContainer, new Object[] {
        //             "begin\n" +
        //             "require 'META-INF/init.rb'\n" +
        //             "require 'META-INF/main.rb'\n" +
        //             "0\n" +
        //             "rescue SystemExit => e\n" +
        //             "e.status\n" +
        //             "end"
        //         })).intValue();
    }

    protected int start() throws Exception {
        URL[] u = extractJRuby();
        return launchRake(u);
    }

    public static void main(String[] args) {
        try {
            int exit = new RakeWarMain(args).start();
            System.exit(exit);
        } catch (Exception e) {
            Throwable t = e;
            while (t.getCause() != null && t.getCause() != t) {
                t = t.getCause();
            }

            if (isDebug()) {
                t.printStackTrace();
            }
            System.exit(1);
        }
    }
}
