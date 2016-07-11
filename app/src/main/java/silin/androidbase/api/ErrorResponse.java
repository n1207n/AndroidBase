package silin.androidbase.api;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

/**
 * Created on 7/11/16: AndroidBase
 */
@AutoValue
public abstract class ErrorResponse {
    public abstract int status_code();

    public abstract String status_message();

    static ErrorResponse create(int status_code, String status_message) {
        return new AutoValue_ErrorResponse(status_code, status_message);
    }

    // Moshi adapter
    public static JsonAdapter<ErrorResponse> jsonAdapter(Moshi moshi) {
        return new AutoValue_ErrorResponse.MoshiJsonAdapter(moshi);
    }
}
