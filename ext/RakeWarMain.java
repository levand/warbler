/**
 * Copyright (c) 2010-2011 Engine Yard, Inc.
 * Copyright (c) 2007-2009 Sun Microsystems, Inc.
 * This source code is available under the MIT license.
 * See the file LICENSE.txt for details.
 */

import org.jruby.Ruby;
import org.jruby.RubyInstanceConfig;
import org.jruby.exceptions.RaiseException;
import org.jruby.javasupport.JavaUtil;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

import java.lang.reflect.Method;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Reader;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URLClassLoader;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
            System.out.println("ruby:" + Ruby.class.getName());
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

