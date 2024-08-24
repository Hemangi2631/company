let dataTable;

$(document).ready(function () {
    bindList();
    $("#dashboard_list_filter").addClass("dt-mb-1");
    $("#dashboard_list_paginate").addClass("dt-mt-1");
    $("#dashboard_list_info").addClass("dt-mt-1");
});

function bindList() {
    dataTable = $("#dashboard_list").DataTable({
        destroy: true,
        serverSide: true,
        pageLength: 10,
        paging: true,
        language: {
            "processing": "<div class='spinner-border avatar-sm text-primary m-2' role='status'></div>",
            "infoFiltered": ""
        },
        columns: [
            {"data": "id"},
            {"data": "name"},
            {"data": "name"}
        ],
        ajax:
            {
                "url": "/datatable",
                "type": "POST",
                "contentType": "application/json",
                "data": function (d) {
                    return JSON.stringify(d);
                },
            }
    });
}
