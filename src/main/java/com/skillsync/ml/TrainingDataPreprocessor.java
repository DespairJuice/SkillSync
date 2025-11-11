package com.skillsync.ml;

import com.skillsync.model.Assignment;
import com.skillsync.ml.features.FeatureExtractor;
import com.skillsync.ml.features.FeatureVector;
import java.util.List;
import java.util.stream.Collectors;

public class TrainingDataPreprocessor {

    public static List<FeatureVector> buildTrainingSet(List<Assignment> assignments) {
        return assignments.stream()
                .map(a -> FeatureExtractor.extract(a.getEmployee(), a.getTask()))
                .collect(Collectors.toList());
    }
}