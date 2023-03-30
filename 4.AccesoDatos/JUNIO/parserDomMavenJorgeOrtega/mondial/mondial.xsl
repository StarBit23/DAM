<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
<xsl:template match="/">
	<html>
		<head>
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous"/>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
		</head>
		<body>
			<h1>Listado de paises</h1>
			<table>
				<tr>
					<th>#</th>
					<th>Nombre Pais</th>
					<th>Habitantes</th>
					<th>Provincia</th>
					<th>Capital</th>
					<th>Ciudad mas poblada</th>
					<th>Continente</th>
				</tr>
			
				<xsl:for-each select="/mondial/country">
					<xsl:sort select="name"></xsl:sort>
				
			<tr>
				<td>
				<xsl:value-of select="position()" />	
				</td>

				<td>
				<xsl:value-of select="name" />	
				</td>

				<td>
				<xsl:value-of select="population[last()]" /> 
				</td>

				<td>
				<xsl:value-of select="count(province)" />
				</td>

				<td>
				<xsl:value-of select="city[@id=../@capital]/name"/>
				</td>

				<td>
				<xsl:value-of select="city[population=max(city/population)]/name" />
				</td>

				<td>
				<xsl:value-of select="encompassed/@continent"/>
				</td>
				
				
			</tr>	
			</xsl:for-each>			
			
			<tr>
					<th>#</th>
					<th>Nombre Pais</th>
					<th>Habitantes</th>
					<th>Provincia</th>
					<th>Capital</th>
					<th>Ciudad mas poblada</th>
					<th>Continente</th>
				</tr>
			
			
			</table>
		</body>
		</html>
</xsl:template>
</xsl:stylesheet>
