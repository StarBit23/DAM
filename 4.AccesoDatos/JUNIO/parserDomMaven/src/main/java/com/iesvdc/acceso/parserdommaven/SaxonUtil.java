/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.parserdommaven;

import java.io.File;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.WhitespaceStrippingPolicy;
import net.sf.saxon.s9api.XPathCompiler;
import net.sf.saxon.s9api.XPathSelector;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmValue;

/**
 * Clase auxiliar con los métodos necesarios para correr expresiones Xpath 
 * contra ficheros de texto XML.
 * @author profesor
 */
public class SaxonUtil {
    String expresionXpath; // expresión como texto xpath
    String fichero; // nombre del fichero completo
    Processor proc; 
    DocumentBuilder builder; // factoría para procesar expresiones xPath o cargar XML
    XPathCompiler xpc; // compilador de expresiones xPath
    XdmNode domDoc; // árbol DOM en memoria, resultado de cargar el fichero XML

    /**
     * Crea un objeto de tipo SaxonUtil pero sin cargar ningún fichero XML
     */
    public SaxonUtil() {
        this.cargarFactoria();
    }
    
    /**
     * 
     */
    private void cargarFactoria(){
        this.proc =  new Processor(false);
        this.builder = proc.newDocumentBuilder();
        this.builder.setLineNumbering(true);
        this.builder.setWhitespaceStrippingPolicy(WhitespaceStrippingPolicy.ALL);
        this.xpc = proc.newXPathCompiler();
    }
    
    /** 
     * Asigna el fichero XML que queremos procesar y lo carga en memoria
     * @param fichero ruta al fichero XML a cargar en memoria
     * @throws net.sf.saxon.s9api.SaxonApiException excepción problemas 
     *  con el fichero
     */
    public void setFichero(String fichero) throws SaxonApiException{
        this.fichero = fichero;
        this.domDoc = this.builder.build(new File(fichero));
    }

    /**
     * Crea un objeto SaxonUtil y carga el archivo que se le pasa como parámetro 
     * en memoria RAM
     * @param fichero 
     * @throws net.sf.saxon.s9api.SaxonApiException 
     */
    public SaxonUtil(String fichero) throws SaxonApiException {
        this.cargarFactoria();
        this.setFichero(fichero);
    }
    
    
    public XdmValue runXPath(String expresion) throws SaxonApiException{
        XdmValue resultado=null;
        XPathSelector xps = xpc.compile(expresion).load();
        xps.setContextItem(this.domDoc);
        resultado = xps.evaluate();
        
        return resultado;
    }
    
    public String xdm2string(XdmValue nodo){
        String resultado="";
        
        for (XdmItem item: nodo) {
           resultado+=item.getStringValue()+"\n";
        }
        
        return resultado;
    }
    
}
