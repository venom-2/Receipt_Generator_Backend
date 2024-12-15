package com.receipt.generator.dto;

public class UpdatePasswordRequest {
    private String _id;
    private String user;
    private String currentPassword;
    private String newPassword;

    public UpdatePasswordRequest() {
    }

    public UpdatePasswordRequest(String _id, String user, String currentPassword, String newPassword) {
        this._id = _id;
        this.user = user;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
