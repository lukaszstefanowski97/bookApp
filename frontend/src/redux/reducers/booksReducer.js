import {books} from '../actions/actionTypes';

const DEFAULT_STATE = {
    books: [],
};

const booksReducer = (state = DEFAULT_STATE, action) => {
    switch (action.type) {
        case books.GET_BOOKS_SUCCESS: {
            return {
                ...state,
                books: action.payload,
            };
        }
        default: {
            return state;
        }
    }
};

export default booksReducer;
