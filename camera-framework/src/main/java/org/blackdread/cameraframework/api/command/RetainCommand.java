package org.blackdread.cameraframework.api.command;

import org.blackdread.camerabinding.jna.EdsdkLibrary.EdsBaseRef;
import org.blackdread.cameraframework.api.constant.EdsdkError;
import org.blackdread.cameraframework.api.helper.factory.CanonFactory;

import static org.blackdread.cameraframework.util.ErrorUtil.toEdsdkError;

/**
 * Retain a ref
 *
 * <p>Created on 2018/12/12.</p>
 *
 * @author Yoann CAPLAIN
 * @since 1.0.0
 */
public class RetainCommand extends AbstractCanonCommand<Void> {

    private final EdsBaseRef baseRef;

    public RetainCommand(final EdsBaseRef baseRef) {
        this.baseRef = baseRef;
    }

    public RetainCommand(final RetainCommand toCopy) {
        super(toCopy);
        this.baseRef = toCopy.baseRef;
    }

    @Override
    protected Void runInternal() {
        final EdsdkError edsdkError = toEdsdkError(CanonFactory.edsdkLibrary().EdsRetain(baseRef));
        if (edsdkError != EdsdkError.EDS_ERR_OK) {
            throw edsdkError.getException();
        }
        return null;
    }
}
