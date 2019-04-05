import React from 'react';
import './books.css';
import PropTypes from 'prop-types';
import {connect} from 'react-redux';
import {withRouter} from 'react-router';

const Books = ({getBooksAction, history, books}) => {
    return (
        <div className="divTable">
            <div className="divTableHeading">
                <div className="divTableHead">1</div>
                <div className="divTableHead">2</div>
                <div className="divTableHead">3</div>
            </div>
            <div className="divTableBody">
                {books.map((book, index) =>
                    <div key={index} className="divTableRow">
                        <div className="divTableCell">{book.title}</div>
                        <div className="divTableCell">&nbsp;</div>
                        <div className="divTableCell">&nbsp;</div>
                    </div>
                )}
            </div>
        </div>
    )
};

Books.propTypes = {
    books: PropTypes.array,
    history: PropTypes.shape({
        push: PropTypes.func.isRequired,
    }).isRequired,
};

const mapStateToProps = () => ({});

const mapDispatchToProps = {
};

export default withRouter(connect(
    mapStateToProps,
    mapDispatchToProps
)(Books));
