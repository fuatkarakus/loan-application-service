package com.fufu.loan.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.domain.LoanApplicantScore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Utils {

    private Utils() { }

    public static List<LoanApplicantScore> getInitialScoreData() {
        try {
            File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "score.json");

            String content = new String(Files.readAllBytes(file.toPath()));

            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(mapper.readValue(content, LoanApplicantScore[].class));
        } catch (IOException e) {
            log.error("Cannot read json file, {}", e.getMessage());
            return new ArrayList<>();
        }
    }
}
