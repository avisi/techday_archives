#
class motd {

  file { '/etc/motd':
    ensure  => present,
    owner   => 'root',
    group   => 'vagrant',
    mode    => '0774',
    content => template('motd/motd.erb');
  }

}
