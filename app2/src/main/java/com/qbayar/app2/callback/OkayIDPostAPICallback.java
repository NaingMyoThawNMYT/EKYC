package com.qbayar.app2.callback;

import com.qbayar.app2.model.OkayIDResponse;

public interface OkayIDPostAPICallback {
    void onResponse(OkayIDResponse okayIDResponse);

    void onFailure(Throwable t);
}
