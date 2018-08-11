import React from 'react';
import compose from 'recompose/compose';
import { connect, dispatch } from 'react-redux';
import { withStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Grid from '@material-ui/core/Grid';
import { Field, reduxForm } from 'redux-form';

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

const renderTextField = ({
  input,
  label,
  type,
  meta: { touched, error },
  ...custom
}) => (
  <TextField
    label={label}
    {...input}
    {...custom}
    type={type}
    className="width-100"
  />
);

const Login = props => {
  const { handleSubmit, submitting, onSubmit } = props;
  return (
    <Grid container justify="center">
      <form
        noValidate
        autoComplete="off"
        onSubmit={handleSubmit(props.onSubmit)}
      >
        <Grid item xs={12}>
          <Field
            id="username"
            label="Username"
            type="text"
            name="username"
            component={renderTextField}
          />
        </Grid>
        <Grid item xs={12}>
          <Field
            id="password"
            label="Password"
            type="password"
            name="password"
            component={renderTextField}
          />
        </Grid>
        <Grid item xs={12}>
          <Button
            variant="contained"
            color="primary"
            className="login-button__width"
            type="submit"
            disabled={submitting}
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
};

const mapStateToProps = state => {
  return {};
};

const mapDispatchToProps = dispatch => {
  return {
    onSubmit: data => {
      dispatch(login(data.username, data.password));
    }
  };
};

export default compose(
  withStyles(styles),
  reduxForm({
    form: 'Login' // a unique identifier for this form
  }),
  connect(
    mapStateToProps,
    mapDispatchToProps
  )
)(Login);
