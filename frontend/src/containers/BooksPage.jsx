import React from 'react';
import {connect} from 'react-redux';
import {withRouter} from 'react-router';
import PropTypes from 'prop-types';
import Books from '../components/books/Books';
import {makeAction} from "../redux/actions/makeAction";
import {books} from "../redux/actions/actionTypes";

class BooksPage extends React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {
        this.props.getBooksAction()
    }

    render() {
        return (
            <Books history={this.props.history} books={this.props.books}/>
        );
    }
}

BooksPage.propTypes = {
    books: PropTypes.array,
    history: PropTypes.shape({
        push: PropTypes.func.isRequired,
    }).isRequired,
};

const mapStateToProps = (state) => ({
    books: state.books.books,
});

const mapDispatchToProps = {
    getBooksAction: makeAction(books.GET_BOOKS),
};

export default withRouter(connect(
    mapStateToProps,
    mapDispatchToProps
)(BooksPage));
