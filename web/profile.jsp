<%-- 
    Document   : profile
    Created on : 21-mei-2019, 15:17:48
    Author     : c1044217
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
        <div class="loginbox box">
                <div class="mx-auto text-center loginfield">
                    <h3 class="login-m-bot">Your Profile</h3>
                       <form  action="InlogServlet">
                        <%Persoon persoon = (Persoon) session.getAttribute("profilePersoon");
                        if(session.getAttribute("editing")==null)  {%>            
                            <div class="form-group w-75 logininputs">
                                <div class="form-inline">
                                    <a>Voornaam:</a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your First Name *" value="<%=persoon.getVoornaam()%>" name="profileVoornaam" readonly>
                                </div>
                            </div>
                            <div class="form-group w-75 logininputs">                                
                                    <div class="form-inline">
                                    <a>Familienaam:  </a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your Last Name *" value="<%=persoon.getFamilienaam()%>" name="profileFamilienaam" readonly>
                                    </div>
                            </div>
                            <div class="form-group w-75 logininputs">                                
                                    <div class="form-inline">
                                    <a>Land:  </a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your Country *" value="<%=persoon.getLand()%>" name="profileLand" readonly>
                                    </div>
                            </div>
                            <div class="form-group w-75 logininputs">                                
                                    <div class="form-inline">
                                    <a>Postcode:  </a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your Postal Code *" value="<%=persoon.getPostcode()%>" name="profilePostcode" readonly>
                                    </div>
                            </div>
                            <div class="form-group w-75 logininputs">                                
                                    <div class="form-inline">
                                    <a>Straat:  </a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your Street *" value="<%=persoon.getStraat()%>" name="profileStraat" readonly>
                                    </div>
                            </div>
                            <div class="form-group w-75 logininputs">                                
                                    <div class="form-inline">
                                    <a>Huisnr:  </a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your House Number *" value="<%=persoon.getHuisnummer()%>" name="profileHuisnummer" readonly>
                                    </div>
                            </div>
                            <div class="form-group w-75 logininputs">                                
                                    <div class="form-inline">
                                    <a>Woonplaats:  </a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your Town *" value="<%=persoon.getWoonplaats()%>" name="profileWoonplaats" readonly>
                                    </div>
                            </div>
                            <div class="form-group w-75 logininputs">                                
                                    <div class="form-inline">
                                    <a>Geboortedatum:  </a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your Birthday *" value="<%=persoon.getGeboortedatum()%>" name="profileGeboortedatum" />
                                    </div>
                            
                            </div>
                            <div class="form-group loginbutton-m-bot w-25 logininputs">
                                    <input class="loginbuttoncolors" type="submit" value="Edit" name="editingKnop"/>
                            </div>
                        <%} else {%>
                            <div class="form-group w-75 logininputs">                                
                                    <div class="form-inline">
                                    <a>Voornaam:  </a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your First Name *" value="<%=persoon.getVoornaam()%>" name="profileVoornaam" />
                                    </div>
                            </div>
                            <div class="form-group w-75 logininputs">                                
                                    <div class="form-inline">
                                    <a>Familienaam:  </a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your Last Name *" value="<%=persoon.getFamilienaam()%>" name="profileFamilienaam" />
                                    </div>
                            </div>
                            <div class="form-group w-75 logininputs">                                
                                    <div class="form-inline">
                                    <a>Land:  </a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your Country *" value="<%=persoon.getLand()%>" name="profileLand" />
                                    </div>
                            </div>
                            <div class="form-group w-75 logininputs">                                
                                    <div class="form-inline">
                                    <a>Postcode:  </a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your Postal Code *" value="<%=persoon.getPostcode()%>" name="profilePostcode" />
                                    </div>
                            </div>
                            <div class="form-group w-75 logininputs">                                
                                    <div class="form-inline">
                                    <a>Straat:  </a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your Street *" value="<%=persoon.getStraat()%>" name="profileStraat" />
                                    </div>
                            </div>
                            <div class="form-group w-75 logininputs">                                
                                    <div class="form-inline">
                                    <a>Huisnr:  </a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your House Number *" value="<%=persoon.getHuisnummer()%>" name="profileHuisnummer" />
                                    </div>
                            </div>
                            <div class="form-group w-75 logininputs">                                
                                    <div class="form-inline">
                                    <a>Woonplaats:  </a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your Town *" value="<%=persoon.getWoonplaats()%>" name="profileWoonplaats" />
                                    </div>
                            </div>                            
                            <div class="form-group w-75 logininputs">                                
                                    <div class="form-inline">
                                    <a>Geboortedatum:  </a>
                                    <input type="text" class="form-control ml-auto" placeholder="Your Town *" value="<%=persoon.getGeboortedatum()%>" name="profileGeboortedatum" />
                                    </div>
                            </div>
                            <div class="form-group loginbutton-m-bot w-25 logininputs">
                                <input class="loginbuttoncolors" type="submit" value="Save Changes" name="saveprofileKnop"/>
                            </div>
                            <div class="form-group cancelbutton-m-bot w-25 logininputs">
                                <input class="loginbuttoncolors" type="submit" value="Cancel" name="cancelKnop"/>
                            </div>
                        <%}%>
                    </form>
                </div>
        </div>
    </body>
</html>
