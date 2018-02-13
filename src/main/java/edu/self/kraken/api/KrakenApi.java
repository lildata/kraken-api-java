package edu.self.kraken.api;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * A KrakenApi instance allows querying the Kraken API.
 *
 * @author nyg
 */
public class KrakenApi {
    
    private static final String OTP = "otp";
    private static final String NONCE = "nonce";
    private static final String MICRO_SECONDS = "000";

    /**
     * Query a public method of the API with the given parameters.
     *
     * @param method the API method
     * @param parameters the method parameters
     * @return the API response
     * @throws IllegalArgumentException if the API method is null
     * @throws IOException if the request could not be created or executed
     */
    public String queryPublic(Method method, Map<String, String> parameters) throws IOException {

        ApiRequest request = new ApiRequest();
        request.setMethod(method);

        if (parameters != null) {
            request.setParameters(parameters);
        }

        return request.execute();
    }

    /**
     * Query a public method of the API without any parameters.
     *
     * @param method the public API method
     * @return the API response
     * @throws IOException if the request could not be created or executed
     */
    public String queryPublic(Method method) throws IOException {
        return queryPublic(method, null);
    }

    /**
     * Represents an API method.
     *
     * @author nyg
     */
    public enum Method {

        /* Public methods */
        TIME("Time", true),
        ASSETS("Assets", true),
        ASSET_PAIRS("AssetPairs", true),
        TICKER("Ticker", true),
        OHLC("OHLC", true),
        DEPTH("Depth", true),
        TRADES("Trades", true),
        SPREAD("Spread", true),


        public final String name;
        public final boolean isPublic;

        Method(String name, boolean isPublic) {
            this.name = name;
            this.isPublic = isPublic;
        }
    }
}
