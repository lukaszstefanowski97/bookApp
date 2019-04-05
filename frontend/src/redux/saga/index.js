import {all, fork} from 'redux-saga/effects';
import authSaga from './authSaga';
import booksSaga from './booksSaga';

export default function *rootSaga() {
    yield all([
        fork(authSaga),
        fork(booksSaga),
    ]);
}
