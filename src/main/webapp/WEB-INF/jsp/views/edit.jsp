<!-- Edit Employee Popup -->
<div class="modal fade" id="editPopup" tabindex="-1" role="dialog" aria-labelledby="editPopupLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editPopupLabel">Edit Employee</h5>
            </div>
            <form id="editForm">
                <div class="modal-body">
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="name">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email">
                    </div>
                    <div class="form-group">
                        <label for="position">Position</label>
                        <input type="text" class="form-control" id="position" name="position">
                    </div>
                    <div class="form-group">
                        <label for="salary">Salary</label>
                        <input type="text" class="form-control" id="salary" name="salary">
                    </div>
                    <div class="form-group">
                        <label for="departmentId">Department ID</label>
                        <input type="text" class="form-control" id="departmentId" name="departmentId">
                    </div>
                    <div class="form-group">
                        <label for="location">Location</label>
                        <input type="text" class="form-control" id="location" name="location">
                    </div>
                </div>
               <div class="modal-footer">
                                   <button type="submit" class="btn btn-primary">Save changes</button>
                               </div>
            </form>
        </div>
    </div>
</div>
