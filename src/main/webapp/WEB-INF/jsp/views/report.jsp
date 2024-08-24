<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="head.jspf" %>
<body>
<header>
    <div class="container">
        <nav class="navbar navbar-expand-md navbar-light">
            <a class="navbar-brand pt-0 pb-0">
                <img src="${pageContext.request.contextPath}/assets/images/logo.png" alt="">
            </a>
            <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation"><span></span><span></span><span></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto w-100">
                    <li class="nav-item">
                        <a class="nav-link cursor-pointer" id="dashboard"
                           href="${pageContext.request.contextPath}/customer/dashboard?host=${host}${authToken}">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active cursor-pointer" id="report"
                           href="${pageContext.request.contextPath}/customer/report?host=${host}${authToken}">Report</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</header>
<div class="wrapper">
    <div class="content pt-45">
        <div class="container">
            <div class="row">
                <div class="white_box">
                    <div class="form-group row">
                        <label for="reportName" class="col-sm-2 col-form-label">Report Type</label>
                        <div class="col-sm-4">
                            <select class="form-control no-search-box arrow-drp-dwn report-name" name="reportName"
                                    id="reportName">
                                <option value="excise-summary-report" selected>Excise Summary Report</option>
                                <option value="excise-order-report">Excise Order Report</option>
                                <option value="wet-summary-report">WET Summary Report</option>
                                <option value="wet-order-report">WET Order Report</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row mt-2">
                        <label for="reportDateRange" class="col-sm-2 col-form-label">Report Date</label>
                        <div class="col-sm-10">
                            <div id="reportDateRange" class="date_info mb-2">
                                <span></span>
                            </div>
                        </div>
                    </div>
                    <form id="form-excise-rate" class="mr-0 ml-auto mt-1">
                        <div class="form-group row mb-2">
                            <label for="exciseRate" class="col-sm-2 col-form-label">Excise</label>
                            <div class="col-sm-2">
                                <input type="number" class="form-control" id="exciseRate"
                                       name="exciseRate" value="94.41" placeholder="Enter excise rate">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="wetRate" class="col-sm-2 col-form-label">WET (exGST Multiplier)</label>
                            <div class="col-sm-2">
                                <input type="number" class="form-control" id="wetRate"
                                       name="wetRate" value="0.22480" placeholder="Enter wet rate">
                            </div>
                            <div class="col-sm-3">
                                <button type="submit" class="add_btn2 btn-width" id="submit-excise-rate"
                                        onclick="setExciseRate()">
                                    Generate Report
                                </button>
                            </div>
                        </div>
                    </form>
                    <hr>
                    <div class="row">
                        <%@include file="datatable.jspf"%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<%@ include file="scripts.jspf" %>
<script src="${pageContext.request.contextPath}/assets/js/sweetalert2.all.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/validator/jquery.validate.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/validator/jquery-form.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/validator/additional-methods.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/toast/jquery.toast.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/datatable/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/common.js"></script>
<script src="${pageContext.request.contextPath}/assets/custom/report.js"></script>
<script src="${pageContext.request.contextPath}/assets/custom/custom.js"></script>
<script src="//cdn.datatables.net/plug-ins/1.13.1/api/sum().js"></script>
</body>
</html>