<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="arrayair">
        <html>
            <body>
                <table border = "1">
                    <tr>
                        <td>color</td>
                        <td>name</td>
                        <td>range</td>
                        <td>amount</td>
                        <td>carrying</td>
                        <td>capacity</td>
                    </tr>
                    <xsl:for-each select="aircraft">
                        <xsl:sort select="color"/>
                        <tr>
                            <td>
                                <xsl:value-of select="color"/>
                            </td>
                            <td>
                                <xsl:value-of select= "name"/>
                            </td>
                            <td>
                                <xsl:value-of select="range"/>
                            </td>
                            <td>
                                <xsl:value-of select="amount"/>
                            </td>
                            <td>
                                <xsl:value-of select="carrying"/>
                            </td>
                            <td>
                                <xsl:value-of select="capacity"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>