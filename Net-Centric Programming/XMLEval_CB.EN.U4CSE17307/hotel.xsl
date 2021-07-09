<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <html>
            <head>
                <style>
                    th{
                    font-family:sans-serif;
                    font-size:16pt;
                    }

                    th,tr{
                        padding:1em;
                        text-align:center;
                    }
                </style>
            </head>

            <body>
                <h1>Customer Records</h1>

                <table border="1">
                    <tr>
                        <th>Host First Name</th>
                        <th>Host Last Name</th>
                        <th>Phone Number</th>
                        <th>Table Number</th>
                        <th>Booking Date</th>
                        <th>Booking Time</th>
                    </tr>

                    <xsl:for-each select="/hotel/customer">
                        <xsl:sort select="BookDate" order="ascending"/>
                        <xsl:sort select="BookTime" order="ascending"/>

                        <tr>
                            <td><xsl:value-of select="FirstName"/></td>
                            <td><xsl:value-of select="LastName"/></td>
                            <td><xsl:value-of select="Phone"/></td>
                            <td><xsl:value-of select="TableNum"/></td>
                            <td><xsl:value-of select="BookDate"/></td>
                            <td><xsl:value-of select="BookTime"/></td>
                        </tr>
                    </xsl:for-each>
                </table>

                <h1> Invitees who ordered Starters </h1>
                <!--<h1> Invitees who ordered items &gt; 300 </h1>-->
                <table border="1" id="table2">
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone Number</th>
                        <th>Host Phone</th>
                        <th>Item Name</th>
                        <th>Item Price</th>
                        <th>Item Type</th>
                    </tr>
                    <xsl:for-each select="/hotel/customer/Invitee">
                        <xsl:for-each select="descendant::item">
                        <tr>
                                <xsl:if test="itemtype='Starter'">
                                <!--<xsl:if test="itemprice &gt; 300">-->
                                    <td><xsl:value-of select="ancestor::Invitee/FirstName"/></td>
                                    <td><xsl:value-of select="ancestor::Invitee/LastName"/></td>
                                    <td><xsl:value-of select="ancestor::Invitee/Phone"/></td>
                                    <td><xsl:value-of select="ancestor::customer/Phone"/></td>
                                    <td><xsl:value-of select="itemname"/></td>
                                    <td><xsl:value-of select="itemprice"/></td>
                                    <td><xsl:value-of select="itemtype"/></td>
                                </xsl:if>   
                        </tr>
                        </xsl:for-each>
                    </xsl:for-each>
                </table>
            </body>
        </html>



    </xsl:template>

</xsl:stylesheet>