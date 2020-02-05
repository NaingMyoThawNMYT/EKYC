package com.qbayar.app2.callback;

import com.qbayar.app2.model.OkayDocMyKadResponse;

public interface OkayDocMyKadPostAPICallback {
    void onResponse(OkayDocMyKadResponse okayDocMyKadResponse);

    void onFailure(Throwable t);
}
