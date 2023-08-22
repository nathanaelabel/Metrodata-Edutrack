package com.metrodata.controllers;

import com.metrodata.entities.CertificateTemplate;
import com.metrodata.entities.models.CertificateTemplateData;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.services.CertificateTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("certificateTemplate")
public class CertificateTemplateController {

    private CertificateTemplateService certificateTemplateService;

    @Autowired
    public CertificateTemplateController(CertificateTemplateService certificateTemplateService) {
        this.certificateTemplateService = certificateTemplateService;
    }

    @GetMapping
    public List<CertificateTemplate> getCertificateTemplate() {
        return certificateTemplateService.getAllCertificateTemplates();
    }

    @GetMapping("{id}")
    public CertificateTemplate getCertificateTemplateById(Long id) {
        return certificateTemplateService.getCertificateTemplateById(id);
    }

    @PostMapping
    public ResponseData<CertificateTemplate> insertCertificateTemplate(CertificateTemplateData certificateTemplateData) {
        return certificateTemplateService.insertCertificateTemplate(certificateTemplateData);
    }

    @PostMapping("{id}")
    public CertificateTemplate updateCertificateTemplate(long id, CertificateTemplate certificateTemplate) {
        return certificateTemplateService.updateCertificateTemplate(id, certificateTemplate);
    }

    @DeleteMapping("{id}")
    public CertificateTemplate deleteCertificateTemplate(long id) {
        return certificateTemplateService.deleteCertificateTemplate(id);
    }
}