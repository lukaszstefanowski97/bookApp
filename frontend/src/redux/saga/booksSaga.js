import {take, put, all, call, fork} from 'redux-saga/effects';
import {books} from '../actions/actionTypes';
import {API_URL} from '../../configuration/config';
import request, {GET} from '../../services/request';

export function *getBooks() {
    while (true) {
        try {
            yield take(books.GET_BOOKS);
            // const response = yield request(GET, API_URL + 'books/');
            const response = yield request(GET, 'https://jsonplaceholder.typicode.com/posts');
            yield put({type: books.GET_BOOKS_SUCCESS, payload: response.data});
        } catch (e) {
            console.error(e);
            yield put({type: books.GET_BOOKS_FAILED, error: e});
        }
    }
}

export default function *booksSaga() {
    yield all([
        fork(getBooks),
    ]);
}
