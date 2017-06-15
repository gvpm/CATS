package cats.dataModels;

import cats.fdps.FDPProviderFactory;
import cats.fdps.FDPProvider;
import com.fasterxml.jackson.annotation.JsonCreator;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Profile {

    @JsonProperty("fdpProviderString")
    String fdpProviderString;
    @JsonProperty("name")
    String name;
    @JsonProperty("size")
    int size;
    @JsonProperty("velMax")
    int velMax;
    @JsonProperty("ahead")
    int ahead;
    @JsonProperty("safeDistance")
    int safeDistance;
    @JsonProperty("velIncrement")
    int velIncrement;
    @JsonProperty("percentageOccurrence")
    double percentageOccurrence;
    @JsonProperty("alphaAcc")
    float alphaAcc;
    @JsonProperty("betaAcc")
    float betaAcc;
    @JsonProperty("alphaAnt")
    float alphaAnt;
    @JsonProperty("betaAnt")
    float betaAnt;
    FDPProvider fdpProvider;
    FDPProviderFactory fdpFactory = new FDPProviderFactory();

    @JsonCreator
    public Profile() {
    }

    public Profile(String fdpProviderString, String name, int size, int velMax, int ahead, int safeDistance, int velIncrement, double percentageOccurrence, float alphaAcc, float betaAcc, float alphaAnt, float betaAnt) {
        this.fdpProviderString = fdpProviderString;
        this.name = name;
        this.size = size;
        this.velMax = velMax;
        this.ahead = ahead;
        this.safeDistance = safeDistance;
        this.velIncrement = velIncrement;
        this.percentageOccurrence = percentageOccurrence;
        this.alphaAcc = alphaAcc;
        this.betaAcc = betaAcc;
        this.alphaAnt = alphaAnt;
        this.betaAnt = betaAnt;
        this.fdpFactory = new FDPProviderFactory();
        this.fdpProvider = fdpFactory.fabricate(fdpProviderString);
    }

    public String getFdpProviderString() {
        return fdpProviderString;
    }

    public void setFdpProviderString(String fdpProviderString) {
        this.fdpFactory = new FDPProviderFactory();
        this.fdpProvider = fdpFactory.fabricate(fdpProviderString);
        this.fdpProviderString = fdpProviderString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getVelMax() {
        return velMax;
    }

    public void setVelMax(int velMax) {
        this.velMax = velMax;
    }

    public int getAhead() {
        return ahead;
    }

    public void setAhead(int ahead) {
        this.ahead = ahead;
    }

    public int getSafeDistance() {
        return safeDistance;
    }

    public void setSafeDistance(int safeDistance) {
        this.safeDistance = safeDistance;
    }

    public int getVelIncrement() {
        return velIncrement;
    }

    public void setVelIncrement(int velIncrement) {
        this.velIncrement = velIncrement;
    }

    public double getPercentageOccurrence() {
        return percentageOccurrence;
    }

    public void setPercentageOccurrence(double percentageOccurrence) {
        this.percentageOccurrence = percentageOccurrence;
    }

    public float getAlphaAcc() {
        return alphaAcc;
    }

    public void setAlphaAcc(float alphaAcc) {
        this.alphaAcc = alphaAcc;
    }

    public float getBetaAcc() {
        return betaAcc;
    }

    public void setBetaAcc(float betaAcc) {
        this.betaAcc = betaAcc;
    }

    public float getAlphaAnt() {
        return alphaAnt;
    }

    public void setAlphaAnt(float alphaAnt) {
        this.alphaAnt = alphaAnt;
    }

    public float getBetaAnt() {
        return betaAnt;
    }

    public void setBetaAnt(float betaAnt) {
        this.betaAnt = betaAnt;
    }

    public FDPProvider getFdpProvider() {
        return fdpProvider;
    }

    public void setFdpProvider(FDPProvider fdpProvider) {
        this.fdpProvider = fdpProvider;
    }

    public FDPProviderFactory getFdpFactory() {
        return fdpFactory;
    }

    public void setFdpFactory(FDPProviderFactory fdpFactory) {
        this.fdpFactory = fdpFactory;
    }

    @Override
    public String toString() {

        return getName() + " Occurrence: " + getPercentageOccurrence() + " Size: " + getSize() + " FDPProvider: " + this.getFdpProvider().toString() + "\nBeta Values: aAcc = " + this.getAlphaAcc() + " bAcc = " + this.getBetaAcc() + "  aAnt = " + this.getAlphaAnt() + " bAnt = " + this.getBetaAnt();
    }

}
