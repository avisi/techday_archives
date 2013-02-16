package nl.avisi.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class GwtServlet extends HttpServlet {

    public GwtServlet() { }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String serverPath = System.getProperty("foundation.server");
        String module = System.getProperty("foundation.module");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        // Print a simple HTML page including a <script> tag referencing your GWT module as the response
        PrintWriter writer = resp.getWriter();
        writer.append("<!doctype html>\n" )
                .append("<html>\n" )
                .append("  <head>\n" )
                .append("    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n" )
                .append("    <title>Foundation</title>\n" )
                .append("    <script type=\"text/javascript\">\n" )
                .append("        erraiBusRemoteCommunicationEnabled = false;\n" )
                .append("        erraiJaxRsJacksonMarshallingActive = true;\n" )
                .append("        erraiJaxRsApplicationRoot = \"" + serverPath + "\";\n" )
                .append("    </script>\n" )
                .append("    <meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\" />\n" )
                .append("    <script type=\"text/javascript\" language=\"javascript\" src=\""+module+"/"+module+".nocache.js\"></script>\n" )
                .append("  </head>\n" )
                .append("  <body>\n" )
                .append("    <iframe src=\"javascript:''\" id=\"__gwt_historyFrame\" tabIndex='-1' style=\"position:absolute;width:0;height:0;border:0\"></iframe>\n" )
                .append("    <noscript>\n" )
                .append("      <div style=\"width: 22em; position: absolute; left: 50%; margin-left: -11em; color: red; background-color: white; border: 1px solid red; padding: 4px; font-family: sans-serif\">\n" )
                .append("        Your web browser must have JavaScript enabled\n" )
                .append("        in order for this application to display correctly.\n" )
                .append("      </div>\n" )
                .append("    </noscript>\n" )
                .append("\n" )
                .append("  </body>\n")
                .append("</html>\n");
    }
}
