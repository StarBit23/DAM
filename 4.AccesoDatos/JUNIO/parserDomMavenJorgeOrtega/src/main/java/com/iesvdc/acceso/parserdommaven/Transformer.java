package com.iesvdc.acceso.parserdommaven;

import java.io.File;

import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.Serializer;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XsltCompiler;
import net.sf.saxon.s9api.XsltExecutable;
import net.sf.saxon.s9api.XsltTransformer;

public class Transformer {
    public static void main(String[] args) {
      if (args.length==3) {
        if (args[0].endsWith(".xml") && args[1].endsWith(".xsl") && args[2].endsWith(".html") ) {
            
        
         try {
            Processor proc = new Processor(false);
            XsltCompiler comp = proc.newXsltCompiler();
            XsltExecutable exp = comp.compile(new StreamSource(new File(args[1])));
            XdmNode source = proc.newDocumentBuilder().build(new StreamSource(new File(args[0])));
            Serializer out = proc.newSerializer(new File(args[2]));
            out.setOutputProperty(Serializer.Property.METHOD, "html");
            out.setOutputProperty(Serializer.Property.INDENT, "yes");
            XsltTransformer trans = exp.load();
            trans.setInitialContextNode(source);
            trans.setDestination(out);
            trans.transform();

            System.out.println("Output written to " + args[2]);
         } catch (Exception e) {
            System.out.println("Error");
         }
         
        }else{
            System.out.println("Faltan parametros");
        }
      }else{
        System.out.println("Introducidos argumentos " + args.length);
        System.out.println("Uso del programa \nTransformer fichero.xml, fichero.xsl, fichero.html");
      }
    }
}
