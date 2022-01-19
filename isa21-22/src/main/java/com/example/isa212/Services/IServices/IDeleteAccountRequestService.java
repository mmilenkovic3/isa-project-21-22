package com.example.isa212.Services.IServices;

import com.example.isa212.Model.DeleteAccountRequest;
import com.example.isa212.Repositories.DeleteAccountRequestRepository;

public interface IDeleteAccountRequestService {
    DeleteAccountRequest deleteAccountRequest(int id);
}
