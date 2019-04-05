import {combineReducers} from 'redux';
import {routerReducer} from 'react-router-redux';
import dashboard from './dashboardReducer';
import auth from './authReducer';
import books from './booksReducer';
import navigation from './navigationReducer';

const root = combineReducers({
    navigation,
    dashboard,
    auth,
    books,
    routing: routerReducer,
});

export default root;
