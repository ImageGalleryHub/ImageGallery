import React, { Component } from 'react';
import compose from 'recompose/compose';
import { connect } from 'react-redux';
import { withStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Grid from '@material-ui/core/Grid';
import { Field, FieldArray, reduxForm } from 'redux-form';

import { login } from '../../actions/loginActions';

import './Login.css';

const styles = theme => ({
  container: {
    display: 'flex',
    flexWrap: 'wrap'
  },
  textField: {
    marginLeft: theme.spacing.unit,
    marginRight: theme.spacing.unit,
    width: 200
  },
  menu: {
    width: 200
  }
});

class Login extends Component {
  render() {
    return (
      <Grid container justify="center">
        <form noValidate autoComplete="off">
          <Grid item xs={12}>
            <TextField
              id="username"
              label="Username"
              placeholder="John Doe"
              margin="normal"
              style={{ width: '100%' }}
              value={this.props.username}
              onChange={this.handleChange.bind(this)}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              id="password"
              label="Password"
              margin="normal"
              type="password"
              value={this.props.password}
              style={{ width: '100%' }}
            />
          </Grid>
          <Grid item xs={12}>
            <Button
              variant="contained"
              color="primary"
              className="login-button__width"
              // value={this.state.password}
              onClick={() => {
                this.props.login(this.props.username, this.props.password);
                // console.log(this.props.password);
                console.log(this.props);
              }}
            >
              Login
            </Button>
          </Grid>
          <p>Don't have an account ? Create it now !</p>
          <Grid item xs={12}>
            <Button variant="contained" color="primary" className="width-100">
              Register
            </Button>
          </Grid>
        </form>
      </Grid>
    );
  }

  handleChange(e) {
    this.setState({ username: e.target.value });
  }
}

const mapStateToProps = state => {
  console.log(state);
  return {
    username: state.login.username,
    password: state.login.password
  };
};

const mapDispatchToProps = dispatch => {
  return {
    login: (username, password) => {
      dispatch(login(username, password));
    }
  };
};

export default compose(
  withStyles(styles),
  connect(
    mapStateToProps,
    mapDispatchToProps
  )
)(Login);
