package com.onetool.server.diabetes.service;

import com.onetool.server.blueprint.Blueprint;
import com.onetool.server.blueprint.dto.BlueprintRequest;
import com.onetool.server.blueprint.dto.BlueprintResponse;
import com.onetool.server.blueprint.dto.SearchResponse;
import com.onetool.server.category.FirstCategoryType;
import com.onetool.server.diabetes.Diabetes;
import com.onetool.server.diabetes.dto.DiabetesRequest;
import com.onetool.server.diabetes.dto.DiabetesResponse;
import com.onetool.server.diabetes.repository.DiabetesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiabetesService {

    private final DiabetesRepository diabetesRepository;

    public DiabetesService(DiabetesRepository diabetesRepository) {
        this.diabetesRepository = diabetesRepository;
    }

    public List<DiabetesResponse> findAllDiabetes() {
        List<Diabetes> diabetesList = diabetesRepository.findAll();

        return diabetesList.stream()
                .map(DiabetesResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public DiabetesResponse findDiabetesById(Long id) {
        Diabetes diabetes = diabetesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diabetes not found with id: " + id));

        return DiabetesResponse.fromEntity(diabetes);
    }

    public boolean createDiabetes(DiabetesRequest diabetesRequest) {
        try {
            Diabetes diabetes = Diabetes.builder()
                    .id(diabetesRequest.id())
                    .diabetesName(diabetesRequest.diabetesName())
                    .categoryId(diabetesRequest.categoryId())
                    .secondCategory(diabetesRequest.secondCategory())
                    .standardPrice(diabetesRequest.standardPrice())
                    .diabetesImg(diabetesRequest.diabetesImg())
                    .diabetesDetailsImg(diabetesRequest.diabetesDetailsImg())
                    .capacity(diabetesRequest.capacity())
                    .calorie(diabetesRequest.calorie())
                    .storage(diabetesRequest.storage())
                    .hits(diabetesRequest.hits())
                    .salePrice(diabetesRequest.salePrice())
                    .saleExpiredDate(diabetesRequest.saleExpiredDate())
                    .build();

            saveDiabetes(diabetes);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Diabetes saveDiabetes(Diabetes diabetes) {
        return diabetesRepository.save(diabetes);
    }

    public boolean updateDiabetes(DiabetesResponse diabetesResponse) {
        Diabetes existingDiabetes = diabetesRepository.findById(diabetesResponse.id())
                .orElseThrow(() -> new RuntimeException("Diabetes not found with id: " + diabetesResponse.id()));

        Diabetes updatedDiabetes = Diabetes.builder()
                .id(existingDiabetes.getId())
                .diabetesName(diabetesResponse.diabetesName())
                .categoryId(diabetesResponse.categoryId())
                .secondCategory(diabetesResponse.secondCategory())
                .standardPrice(diabetesResponse.standardPrice())
                .diabetesImg(diabetesResponse.diabetesImg())
                .diabetesDetailsImg(diabetesResponse.diabetesDetailsImg())
                .capacity(diabetesResponse.capacity())
                .calorie(diabetesResponse.calorie())
                .storage(diabetesResponse.storage())
                .hits(diabetesResponse.hits())
                .salePrice(diabetesResponse.salePrice())
                .saleExpiredDate(diabetesResponse.saleExpiredDate())
                .build();

        diabetesRepository.save(updatedDiabetes);
        return true;
    }

    public boolean deleteDiabetes(Long id) {
        diabetesRepository.deleteById(id);
        return true;
    }

}