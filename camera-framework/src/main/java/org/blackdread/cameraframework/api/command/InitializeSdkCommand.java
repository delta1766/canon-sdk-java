package org.blackdread.cameraframework.api.command;

import org.blackdread.cameraframework.api.constant.EdsdkError;
import org.blackdread.cameraframework.api.helper.factory.CanonFactory;

import static org.blackdread.cameraframework.util.ErrorUtil.toEdsdkError;

/**
 * Initialize the sdk from the command dispatcher thread
 *
 * <p>Created on 2018/12/12.</p>
 *
 * @author Yoann CAPLAIN
 * @since 1.0.0
 */
public class InitializeSdkCommand extends AbstractCanonCommand<Void> {

    public InitializeSdkCommand() {
    }

    public InitializeSdkCommand(final InitializeSdkCommand toCopy) {
        super(toCopy);
    }

    @Override
    protected Void runInternal() {
        final EdsdkError edsdkError = toEdsdkError(CanonFactory.edsdkLibrary().EdsInitializeSDK());
        if (edsdkError != EdsdkError.EDS_ERR_OK) {
            throw edsdkError.getException();
        }
        return null;
    }
}
