let dataTable;

$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

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
            {"data": "email"},
            {"data": "position"},
            {"data": "salary"},
            {"data": "departmentId"},
            {"data": "location"},
            {"data": "departmentName"},
            {
                "data": "id",
                "render":()=> "<button class='btn btn-primary btn-sm edit-btn'>Edit</button> <button class='btn btn-danger btn-sm delete-btn'>Delete</button>",
                "orderable": false
            }
        ],
        ajax: {
            "url": "/datatable",
            "type": "POST",
            "contentType": "application/json",
            "data": function (d) {
                return JSON.stringify(d);
            }
        }
    });

    $('#dashboard_list').on('click', '.edit-btn', function () {
        const data = dataTable.row($(this).parents('tr')).data();
        showEditPopup(data);
    });

    $('#dashboard_list').on('click', '.delete-btn', function () {
        const data = dataTable.row($(this).parents('tr')).data();
        if (confirm(`Are you sure you want to delete employee with ID ${data.id}?`)) {
            deleteEmployee(data.id);
        }
    });
}

function showEditPopup(data) {
    // Fill the popup fields with data
    $('#editForm #id').val(data.id);
    $('#editForm #name').val(data.name);
    $('#editForm #email').val(data.email);
    $('#editForm #position').val(data.position);
    $('#editForm #salary').val(data.salary);
    $('#editForm #departmentId').val(data.departmentId);
    $('#editForm #location').val(data.location);
    $('#editForm #departmentName').val(data.departmentName);

    $('#editPopup').modal('show');
}

function deleteEmployee(id) {
    $.ajax({
        url: `/api/deleteEmployee/`+id,
        type: 'DELETE',
        success: function () {
            dataTable.ajax.reload(); // Refresh the table data
        },
        error: function () {
            alert('Error deleting employee');
        }
    });
}

$('#editForm').on('submit', function (event) {
    event.preventDefault();
    var formData = $(this).serializeObject();
    $.ajax({
        url: '/api/updateEmployee',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(formData),
        success: function () {
            $('#editPopup').modal('hide');
            dataTable.ajax.reload();
        },
        error: function () {
            alert('Error updating employee');
        }
    });
});


