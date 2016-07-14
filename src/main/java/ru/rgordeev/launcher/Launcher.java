package ru.rgordeev.launcher;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.*;

import java.net.URL;
import java.security.ProtectionDomain;

/**
 * Created by rgordeev on 14.07.16.
 */
public class Launcher {

    public static void main(String[] args) throws Exception {
        ProtectionDomain domain = Launcher.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        // create a web app and configure it to the root context of the server
        WebAppContext webapp = new WebAppContext();
        webapp.setDescriptor( "WEB-INF/web.xml" );
        webapp.setConfigurations( new Configuration[] { new AnnotationConfiguration(),
                new WebXmlConfiguration(), new WebInfConfiguration(), new MetaInfConfiguration()
                // , new FragmentConfiguration(), new EnvConfiguration(), new PlusConfiguration()
        } );
        webapp.setContextPath( "/" );
        webapp.setWar( location.toExternalForm() );

        // starts the embedded server and bind it on 8081 port
        Server server = new Server( 8080 );
        server.setHandler( webapp );
        server.start();
        server.join();
    }
}
