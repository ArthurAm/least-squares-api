package com.least_squares.main.service;

import com.least_squares.main.service.dto.LSFormulaData;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

@Service
final public class LSCalculator implements RegressionCalculator
{
    private List<double[]> data = new ArrayList<>();

    @Override
    public Double calculateIntercept() {
        LSFormulaData formulaData = getFormulaData();
        return (formulaData.summY - calculateScope() * formulaData.summX) / formulaData.pointCount;
    }

    @Override
    public Double calculateScope() {
        LSFormulaData formulaData = getFormulaData();
        return (formulaData.pointCount * formulaData.summXY - formulaData.summX * formulaData.summY) /
                (formulaData.pointCount * formulaData.summPowX - Math.pow(formulaData.summX, 2));
    }

    public Double calculateSlopeStandartError() {
        LSFormulaData formulaData = getFormulaData();
        return calculateStandartError() / Math.sqrt(formulaData.summPowX - formulaData.avgX * formulaData.summX);
    }

    public Double calculateSlopeTValue() {
        return calculateScope() / calculateSlopeStandartError();
    }

    public Double calculateStandartError() {
        LSFormulaData formulaData = getFormulaData();
        return Math.sqrt((formulaData.summPowY - calculateIntercept() * formulaData.summY - calculateScope() * formulaData.summXY) / (formulaData.pointCount - 2));
    }

    public Double calculateRSquared() {
        LSFormulaData formulaData = getFormulaData();
        return Math.pow(formulaData.pointCount * formulaData.summXY - formulaData.summX * formulaData.summY, 2) /
                ((formulaData.pointCount * formulaData.summPowX - Math.pow(formulaData.summX, 2)) * (formulaData.pointCount * formulaData.summPowY - Math.pow(formulaData.summY, 2)));
    }

    public void addData(double x, double y) {
        double[] pointData = {x, y};
        this.data.add(pointData);
    }

    public void clear() {
        this.data.clear();
    }

    private LSFormulaData getFormulaData() {
        LSFormulaData formulaData = new LSFormulaData();
        formulaData.pointCount = this.data.size();
        for (int i = 0; i < formulaData.pointCount; i++) {
            double[] point = this.data.get(i);
            double x = point[0];
            double y = point[1];
            formulaData.summX = formulaData.summX + x;
            formulaData.summY = formulaData.summY + y;
            formulaData.summXY = formulaData.summXY + x*y;
            formulaData.summPowY = formulaData.summPowY + Math.pow(y, 2);
            formulaData.summPowX = formulaData.summPowX + Math.pow(x, 2);
        }
        formulaData.avgX = formulaData.summX / formulaData.pointCount;
        formulaData.avgY = formulaData.summY / formulaData.pointCount;

        return formulaData;
    }
}
