<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:h="http://www.epam.training.by/classes">

    <xsl:template match="/">
        <html>
            <head>
                <style>
                    table {
                    font-family: arial, sans-serif;
                    }
                    th {
                    padding: 8px;
                    }
                    tr:nth-child(even) {
                    background-color: #dddddd;
                    }
                </style>
            </head>
            <body>
                <h1 align="center">Candy Catalog</h1>
                <table border="1" style="width:100%">
                    <tr bgcolor="#19436d" style="color:white;">
                        <th>ID</th>
                        <th>Type</th>
                        <th>Name</th>
                        <th>Energy</th>
                        <th>Ingredients</th>
                        <th>Value</th>
                        <th>Production</th>
                    </tr>
                    <xsl:for-each select="/h:candies/h:candy">
                        <tr>
                            <td><xsl:value-of select="@id" /></td>
                            <td><xsl:value-of select="@type" /></td>
                            <td><xsl:value-of select="h:name" /></td>
                            <td><xsl:value-of select="h:energy" /></td>
                            <td>
                            <xsl:for-each select="h:ingredients">
                                <xsl:for-each select="node()">
                                    <table>
                                        <tr>
                                            <td><xsl:value-of select="name()"/></td>
                                            <td><xsl:value-of select="."/></td>
                                        </tr>
                                    </table>
                                </xsl:for-each >
                            </xsl:for-each>
                            </td>
                            <td>
                                <xsl:for-each select="h:value">
                                    <xsl:for-each select="node()">
                                        <table>
                                            <tr>
                                                <td><xsl:value-of select="name()"/></td>
                                                <td><xsl:value-of select="."/></td>
                                            </tr>
                                        </table>
                                    </xsl:for-each >
                                </xsl:for-each>
                            </td>
                            <td><xsl:value-of select="h:production" /></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>