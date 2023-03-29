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
        try {
            Processor proc = new Processor(false);
            XsltCompiler comp = proc.newXsltCompiler();
            XsltExecutable exp = comp.compile(new StreamSource(new File("styles/books.xsl")));
            XdmNode source = proc.newDocumentBuilder().build(new StreamSource(new File("data/books.xml")));
            Serializer out = proc.newSerializer(new File("books.html"));
            out.setOutputProperty(Serializer.Property.METHOD, "html");
            out.setOutputProperty(Serializer.Property.INDENT, "yes");
            XsltTransformer trans = exp.load();
            trans.setInitialContextNode(source);
            trans.setDestination(out);
            trans.transform();

            System.out.println("Output written to books.html");
        } catch (Exception e) {
            System.out.println("Error");
        }
        
    }
}
