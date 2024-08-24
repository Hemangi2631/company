<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%@ include file="head.jspf" %>
<body>
<div class="wrapper">
    <div class="content pt-45">
        <div class="container">
            <div class="row">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                    <div class="white_box">
                        <h5 class="title">Employee Details</h5>
                        <hr>
                        <div class="table_info prod_list_table">
                            <table class="table table-bordered w-100 mt-1" id="dashboard_list">
                                <thead>
                                <tr>
                                    <th>Employee ID</th>
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Position</th>
                                    <th>Salary</th>
                                    <th>Department ID</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="scripts.jspf" %>
<script src="${pageContext.request.contextPath}/assets/js/datatable/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/assets/custom/dashboard.js"></script>

</body>
</html>
