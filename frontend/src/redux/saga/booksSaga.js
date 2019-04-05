import {take, put, all, call, fork} from 'redux-saga/effects';
import {auth, books} from '../actions/actionTypes';
import {API_URL} from '../../configuration/config';
import request, {GET, POST} from '../../services/request';

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

export function *addBook() {
    while (true) {
        try {
            const { payload: { data, callback } } = yield take(books.ADD_BOOK);
            const response = yield request(POST, `${API_URL}/api/addBook`, data);
            yield put({type: books.ADD_BOOK_SUCCESS, payload: response.data});
            yield call(callback);
        } catch (e) {
            console.error(e);
            yield put({type: books.ADD_BOOK_FAILED, error: e});
        }
    }
}

export default function *booksSaga() {
    yield all([
        fork(getBooks),
        fork(addBook),
    ]);
}
