#
# puppet_apply_file.pp
#
# ``puppet apply`` to execute this puppet manifest
# run puppet lint so you can fix some style and syntax errors in this file

# commands line:
# puppet lint puppet_apply_file.pp  (... the package name is 'puppet-lint' :P ... )
# puppet apply puppet_apply_file.pp

  user { elvis:
    ensure => 'present',
  }

  package { 'cow': 
    ensure => 'absent',
  }

  exec { 'apt update':
    command => 'apt-get update',
    path => '/usr/bin',
    logoutput => true,
  }

  package { 'apache2':
    ensure => 'latest',
    require => Exec['apt update'],
  }

  service { 'apache2':
    enable => 'false',
    ensure => 'stopped',
    require => Package['apache2'],
  }

  file { '/etc/motd':
    content => "\noperatingsystem: $::operatingsystem \nhardware manufacturer: $::manufacturer \n\n",
  } 

