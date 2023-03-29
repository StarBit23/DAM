<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
<xsl:template match="/">
	<html>
		
		<body>
			<h1>Listado alfabético de plantas ORDENADO por luz y nombre</h1>
			<table>
				<tr>
					<th>Número</th>
					<th>Nombre</th>
					<th>Especie</th>
					<th>Zona</th>
					<th>Luz</th>
					<th>Precio</th>
					<th>IVA</th>
					<th>Precio con IVA</th>
				</tr>
			
			<xsl:for-each select="/CATALOG/PLANT">
				<xsl:sort select="LIGHT" />
				<xsl:sort select="ZONE" />
				<xsl:sort select="COMMON" />
			
			<tr>
				<td>
				<xsl:value-of select="position()" />	
				</td>
				<td>
				<xsl:value-of select="COMMON" /> 
				</td>
				<td>
				<xsl:value-of select="BOTANICAL" />
				</td>
				<td>
				<xsl:value-of select="ZONE" />
				</td>
				<td>
				<xsl:value-of select="LIGHT" />
				</td>
				<td>
				$ <xsl:value-of select="substring-after(PRICE, '$')" />
				</td>
				<td> 
				$ <xsl:value-of select="format-number(0.21*number(substring-after(PRICE, '$')), '#.00' )" />
				</td>
				<td>
				$ <xsl:value-of select="format-number(1.21*number(substring-after(PRICE, '$')), '#.00')" />
				</td>
				
				
			</tr>	
			</xsl:for-each>			
			
			<tr>
					<th>Número</th>
					<th>Nombre</th>
					<th>Especie</th>
					<th>Zona</th>
					<th>Luz</th>
					<th>Precio</th>
					<th>IVA</th>
					<th>Precio con IVA</th>
				</tr>
			
			
			</table>
		</body>
		</html>
</xsl:template>
</xsl:stylesheet>
