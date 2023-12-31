package com.metrodata.services;

import com.metrodata.entities.CertificateTemplate;
import com.metrodata.entities.models.CertificateTemplateData;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.repositories.CertificateTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificateTemplateService {

    private final SessionDetailService sessionDetailService;
    private final CertificateTemplateRepository certificateTemplateRepository;

    public List<CertificateTemplate> getAllCertificateTemplates() {
        return certificateTemplateRepository.findAll();
    }

    public CertificateTemplate getCertificateTemplateById(Long id) {
        return certificateTemplateRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CertificateTemplate with ID: " + id + " not found"));
    }

    public ResponseData<CertificateTemplate> insertCertificateTemplate(CertificateTemplateData certificateTemplateData) {
        try {
            CertificateTemplate certificateTemplate = new CertificateTemplate();
            certificateTemplate.setCertificateUrl(certificateTemplateData.getCertificateUrl());
            certificateTemplate.setSessionDetail(sessionDetailService.getSessionDetailById(certificateTemplateData.getSessionDetailId()));
            CertificateTemplate newCertificateTemplate = certificateTemplateRepository.save(certificateTemplate);
            return new ResponseData<>(newCertificateTemplate, "Certificate Template created successfully");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public CertificateTemplate updateCertificateTemplate(long id, CertificateTemplate certificateTemplateData) {
        CertificateTemplate certificateTemplate = getCertificateTemplateById(id);
        certificateTemplate.setCertificateUrl(certificateTemplateData.getCertificateUrl());
        certificateTemplate.setSessionDetail(sessionDetailService.getSessionDetailById(certificateTemplateData.getSessionDetail().getId()));
        return certificateTemplateRepository.save(certificateTemplate);
    }

    public CertificateTemplate deleteCertificateTemplate(long id) {
        CertificateTemplate certificateTemplate = getCertificateTemplateById(id);
        certificateTemplateRepository.delete(certificateTemplate);
        return certificateTemplate;
    }
}
