<%-- 
    Document   : action
    Created on : Dec 2, 2018, 4:43:12 PM
    Author     : lokesh
--%>
<%@page import="java.sql.ResultSet"%>
<%@ page import="com.database.Database_controller" %>
<html>
    <head>
        <link rel="stylesheet" href="styleforapp.css">
        <script src="javascriptforapp.js"></script>
    </head>
    <body>

        <div style="boarder: 2px solid black;">
            <form action="controller_to_save_time" id="myForm" > 
                <div id="head">
                    <input type="text" name="working_on" id="a" placeholder="type what are you doing"/>
                    <select  name="category" onchange="getval(this);">
                        <option value="select">select category</option>


                        <option value="Personal" >Personal</option>
                        <option value="Work">Work</option>
                        <option value="Meeting">Meeting</option>
                        <option value="Refreshment">Refreshment</option>


                    </select>


                    <input type="hidden" id="time" name="time_elapsed" value="00">

                </div>
            </form>
            </br>

            <div class="container" id="ta1" style="visibility: hidden">
                <div>  
                    <table style="margin-left:-250px">
                        <th>  
                            <button id= "startPause" onclick="startPause()"><b id="start">Start</b></button></th>
                        <th><h1><p id="output">0:00:00:00</p></h1></th>


                        <th><button onclick="get_total_time()" id="reset"><b id="reset">Stop</b</button></th>

                    </table>
                </div>
            </div>
            <table style="margin-top: 100px;">
                <tr>
                    <th>Working on</th>
                    <th>Category</th>
                    <th>Duration</th>
                    <th>Date</th>
                </tr>
                <%
                    Database_controller db = new Database_controller();
                    ResultSet rs = db.get();
                    while (rs.next()) {
                %>
                <tr>
                    <td><%=rs.getString(2)%></td>
                    <td><%=rs.getString(3)%></td>
                    <td><%=rs.getString(4)%></td>
                    <td><%=rs.getString(5)%></td>
                </tr>
                <%}%>
            </table>

        </div>

    </body>
</html>


