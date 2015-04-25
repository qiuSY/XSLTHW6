<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
<html>
	<head>
	</head>
	<body>
		<ol>
		<xsl:for-each select="siteList/site/tower/equipment">
			<xsl:choose>
				<xsl:when test="@stars &gt; 3">
					<li style="background-color: green">
						<xsl:value-of select="@name"/>
						<xsl:text>, </xsl:text>
						<xsl:value-of select="@brand"/>
												<xsl:text>, </xsl:text>
						<xsl:value-of select="@description"/>
												<xsl:text>, </xsl:text>
						<xsl:value-of select="@price"/>
						site: 
						<xsl:value-of select="../../@name"/>
						<xsl:text>, </xsl:text>
						<xsl:value-of select="../../@latitude"/>
												<xsl:text>, </xsl:text>
						<xsl:value-of select="../../@longitude"/>
						tower: 
						<xsl:value-of select="../@name"/>
						<xsl:text>, </xsl:text>
						<xsl:value-of select="../@height"/>
												<xsl:text>, </xsl:text>
						<xsl:value-of select="../@sides"/>
					</li>
				</xsl:when>
				<xsl:otherwise>
					<li>
						<xsl:value-of select="@name"/>
						<xsl:text>, </xsl:text>
						<xsl:value-of select="@brand"/>
												<xsl:text>, </xsl:text>
						<xsl:value-of select="@description"/>
												<xsl:text>, </xsl:text>
						<xsl:value-of select="@price"/>
						site: 
						<xsl:value-of select="../../@name"/>
						<xsl:text>, </xsl:text>
						<xsl:value-of select="../../@latitude"/>
												<xsl:text>, </xsl:text>
						<xsl:value-of select="../../@longitude"/>
						tower: 
						<xsl:value-of select="../@name"/>
						<xsl:text>, </xsl:text>
						<xsl:value-of select="../@height"/>
												<xsl:text>, </xsl:text>
						<xsl:value-of select="../@sides"/>
					</li>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:for-each>
		</ol>
	</body>
	</html>
	</xsl:template>
</xsl:stylesheet>