package br.com.api.credit.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class MoneySerializer extends StdSerializer<BigDecimal> {

    public MoneySerializer() {
        super(BigDecimal.class);
    }

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        Locale localeBrazil = new Locale.Builder().setLanguage("pt").setRegion("BR").build();
        NumberFormat formatter = NumberFormat.getCurrencyInstance(localeBrazil);
        String formattedValue = formatter.format(value);
        gen.writeString(formattedValue);
    }

}
