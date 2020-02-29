package procurations.dto;

public abstract class Procuration {

    public ProcurationDto procurationDto;

    public ProcurationDto getProcuration() {
        if (procurationDto == null) {
            return new ProcurationDto();
        } else {
            return procurationDto;
        }
    }
}
